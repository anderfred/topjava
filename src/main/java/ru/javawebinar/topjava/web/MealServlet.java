package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    private static List<Meal> list;

    static {
        list = new ArrayList();
        list.add(new Meal(LocalDateTime.of(2015, Month.OCTOBER, 30, 10, 0), "Завтрак", 1400));
        list.add(new Meal(LocalDateTime.of(2012, Month.JANUARY, 30, 19, 0), "Ужин", 300));
        list.add(new Meal(LocalDateTime.of(2015, Month.APRIL, 12, 12, 32), "Обед", 600));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 4, 0), "Завтрак", 500));
        list.add(new Meal(LocalDateTime.of(2015, Month.FEBRUARY, 21, 10, 0), "Завтрак", 769));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 346));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        List<MealWithExceed> mealWithExceeds = new ArrayList<>();
        list.forEach(v -> mealWithExceeds.add(MealsUtil.createWithExceed(v, v.getCalories() > 500 ? true : false)));
        request.setAttribute("meal", mealWithExceeds);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
