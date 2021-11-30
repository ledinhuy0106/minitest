package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceIplm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceIplm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete" :
                deleteForm(request , response);
                break;case "edit" :
                editForm(request , response);
                break;
            default:
                showListStudent(request,response);

        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("edit",student);
        requestDispatcher.forward(request, response);
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = this.studentService.findAll();
        request.setAttribute("students",studentList );
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/StudentList.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
            deleteProduct(request, response);
            break; case "edit":
            editProDuct(request, response);
            break;
        }
    }

    private void editProDuct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double math= Double.parseDouble(request.getParameter("math"));
        double physics= Double.parseDouble(request.getParameter("physics"));
        double chemistry= Double.parseDouble(request.getParameter("chemistry"));
        studentService.update(id,new Student(id, name , math , physics,chemistry));
        response.sendRedirect("/students");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentService.delete(id);
        response.sendRedirect("/students");
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("delete", student);
        requestDispatcher = request.getRequestDispatcher("view/StudentDelete.jsp");
        requestDispatcher.forward(request, response);
    }
}
