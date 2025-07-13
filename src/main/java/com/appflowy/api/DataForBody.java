package com.appflowy.api;

import java.util.Arrays;
import java.util.List;

public class DataForBody {
    public List<String> templateNames = Arrays.asList(
            "Simple Weekly To-Do List",
            "Project Plan One Pager",
            "Scrum Board Template",
            "Agile Board Template",
            "Eisenhower Matrix",
            "HR Team Project Tracker",
            "Project Tracker",
            "Simple Project Board"
    );
    public String requestBody = """ 
            {
            "code_challenge": "",
            "code_challenge_method": "",
            "data": {},
            "email": "nicoleryabov@gmail.com"
        }
        """;
    public String invalidRequestBody = """ 
            {
            "code_challenge": "",
            "code_challenge_method": "",
            "data": {},
            "email": "nicolтотаотаолуцv@gmail.com"
        }
        """;
    public String email = "nicoleryabov@gmail.com";

}
