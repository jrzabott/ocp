package com.ocp.chapter9;

import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPaths {
    public static void main(String[] args) {
        Path path = Paths.get("/home/users/jundan/IdeaProjects/ocp/src/main/java/com/ocp/chapter9/CreatingPaths.java");
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }
        System.out.println(path);
    }
}
