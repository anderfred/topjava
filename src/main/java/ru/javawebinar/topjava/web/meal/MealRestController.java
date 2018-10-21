package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

@Controller
public class MealRestController extends AbstractMealController {

    @Override
    public Meal create(Meal meal) {
        return super.create(meal);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        super.delete(id);
    }

    @Override
    public Meal get(int id, int userId) throws NotFoundException {
        return super.get(id, userId);
    }

    @Override
    public void update(Meal meal) {
        super.update(meal);
    }

    @Override
    public List<Meal> getAll() {
        return super.getAll();
    }
}