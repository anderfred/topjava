package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealServiceImpl mealService;

    Meal create(Meal meal) {
        log.info("create {}", meal);
        return mealService.create(meal);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete {}", id);
        mealService.delete(id);
    }

    public Meal get(int id, int userId) throws NotFoundException {
        log.info("get {}", id, userId);
        return mealService.get(id, userId);
    }

    public void update(Meal meal) {
        log.info("update {}", meal);
        mealService.update(meal);
    }

    public List<Meal> getAll() {
        log.info("getAll {}");
        return mealService.getAll();
    }
}
