package com.example.demo.config;

import jakarta.servlet.http.HttpSession;

public class Utils {
    public static void setSessionUsername(HttpSession session, String username) {
        session.setAttribute("username", username);
    }

    public static String getSessionUsername(HttpSession session) {
        try {
            String username = (String) session.getAttribute("username");
            if (username == null) {
                return "";
            }
            return username;
        } catch (Exception e) {
            return "";
        }
    }

    public static void setSessionUUID(HttpSession session, long uuid) {
        session.setAttribute("id", uuid);
    }

    public static Long getSessionUUID(HttpSession session) {
        try {
            Long userId = (Long) session.getAttribute("id");
            if (userId == null) {
                return -1L;
            }
            return userId;
        } catch (Exception e) {
            return -1L;
        }
    }
}