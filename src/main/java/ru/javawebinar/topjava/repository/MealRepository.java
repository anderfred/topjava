package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;

import java.util.List;

@Repository
public interface MealRepository {

    Meal save(Meal meal);

    boolean delete(int id);

    Meal get(int id);

    List<Meal> getAll();
}
