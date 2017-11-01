package com.group.meal.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by whz on 2017/11/1.
 */
public class ResponseUtil {

    public static void writeJson(HttpServletResponse response, String json) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Connection", "close");
        response.setContentType("application/text;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            if (writer != null) {
                writer.write(json);
            }
        } catch (IOException e) {

        }
    }

    public static void writeHtml(HttpServletResponse response, String html) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            if (writer != null) {
                writer.write(html);
            }
        } catch (IOException e) {

        }
    }

}
