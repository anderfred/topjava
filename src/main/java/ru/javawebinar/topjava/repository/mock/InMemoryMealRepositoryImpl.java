package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        // treat case: update, but absent in storage
        return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public boolean delete(int id) {
        Object notFound = repository.remove(id);
        if (null == notFound) {
            return false;
        } else return true;
    }

    @Override
    public Meal get(int id) {
        if (repository.get(id).getUserId() == SecurityUtil.authUserId()) return repository.get(id);
        else return null;
    }

    @Override
    public List<Meal> getAll() {
        List<Meal> mealList = new ArrayList<>(repository.values());
        mealList.sort(Comparator.comparing(Meal::getDate).reversed());
        return mealList;
    }
}

