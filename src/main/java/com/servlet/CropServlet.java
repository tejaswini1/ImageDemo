package com.servlet;

import com.helper.FileUrl;
import com.helper.ImageReader;
import com.helper.Response;
import com.utility.ImageCropper;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;


public class CropServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int xCoordinate = Integer.parseInt(request.getParameter("x"));
        int yCoordinate = Integer.parseInt(request.getParameter("y"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String url = request.getParameter("url");
        ImageReader imageReader = new ImageReader();
        BufferedImage image;
        try {
            image = imageReader.readImage(new URL(url));
        } catch (IOException ioException) {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<html><body>" + ioException.getStackTrace() + "</body><html>");
            return;
        }
        ImageCropper imageCropper = new ImageCropper();
        image = imageCropper.getCroppedImage(image, xCoordinate, yCoordinate, width, height);

        Response servletResponse = new Response();
        servletResponse.setResponse(response, image, url);
    }


}
