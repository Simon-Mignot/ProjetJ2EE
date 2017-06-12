/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monapp.resources;

import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CourseManager
{

    private List<Course> listeCourses;
    private long id;

    public CourseManager()
    {
        listeCourses = new ArrayList<Course>();
        id = 0;
    }

    public List<Course> findCourses()
    {
        return listeCourses;
    }

    public Course findCourse(Long n)
    {
        for (int i = 0; i < listeCourses.size(); ++i)
        {
            if (listeCourses.get(i).getId() == n)
            {
                return listeCourses.get(i);
            }
        }
        return null;
    }

    public Course saveCourse(Course c)
    {
        if (c.getId() == null)
        {
            id++;
            c.setId(id);
            listeCourses.add(c);
        } else
        {
            for (int i = 0; i < listeCourses.size(); ++i)
            {
                if (listeCourses.get(i).getId() == c.getId())
                {
                    return listeCourses.set(i, c);
                }
            }
        }
        return c;
    }

    public void deleteCourse(Course c)
    {
        listeCourses.remove(c);
    }
}
