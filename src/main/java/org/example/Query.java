package org.example;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * 
 * @phase process-sources
 */

@Mojo(name="dbconnect")
public class Query
    extends AbstractMojo
{
    @Parameter(property = "query.url")
    private String url;

    @Parameter(property = "db.password")
    private String password;

    @Parameter(property = "db.username")
    private String username;


    public void execute() throws MojoExecutionException
    {
        try{
            getLog().info(url);
            getLog().info(username);
            getLog().info(password);
            Connection connection = DriverManager.getConnection(url, username, password);
            getLog().info("Conexão realizada!");

        }catch(RuntimeException e){
            throw new MojoExecutionException("");
        } catch (SQLException e) {
            throw new MojoExecutionException(e.getMessage());
        }

    }
}
