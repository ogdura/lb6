package com.example.demo6;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import java.lang.String;


public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
      /*  String str = files[0].getName();
        System.out.println(str.substring(0,str.lastIndexOf(".")));*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        class bebra{
            class size {
                int strok;
                int solb;

                void getSize(File[] dir) {
                    strok = dir.length;
                    int m=0;
                    for (File file1 : dir) {
                        File[] childfile = file1.listFiles();
                        if(m<childfile.length){
                            m=childfile.length;
                        }
                    }
                    solb=m;
                }
            }
            String[][] getChild(String path){
                File dir = new File(path);
                File[] filesdir = dir.listFiles();
                size size = new size();
                size.getSize(filesdir);
                String[][] files = new String[size.strok][size.solb+1];
                System.out.println(size.solb);
                int i = 0;
                for (File file : filesdir) {
                    int j = 0;
                    File[] filesfile = file.listFiles();
                    files[i][0]=file.getName();
                    for (File file1 : filesfile) {
                        files[i][j+1]=file1.getName();
                        j++;
                    }
                    i++;
                }
                return files;
            }
        }
        bebra bebra = new bebra();
        String[][] map = bebra.getChild("C:\\Users\\User\\IdeaProjects\\demo6\\src\\main\\txt");
        req.setAttribute("map", map);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("namee");
        String Newname=name.replace('_','\\');
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String fileName = "C:\\Users\\User\\IdeaProjects\\demo6\\src\\main\\txt\\"+Newname;
        String content = Files.lines(Paths.get(fileName)).reduce("", String::concat);
        writer.println("<p style='color:blue;text-align:center;font-size:30px'>" + content + "</p>");
        Files.lines(Paths.get(fileName), Charset.forName("windows-1251"));
    }



    public void destroy() {
    }
}