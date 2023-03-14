# CHANGELOG

All notable changes to this project will be documented in this file.

# v1.0

- feat: initial setup
- feat: add CHANGELOG.md
- feat: update .gitignore
- feat: add the apollo plugin to our project level build.gradle file
- feat: add the apollo runtime dependency on app level build.gradle file
- feat: add apollo service dependency on app level build.gradle file
- feat: update the apollo plugin to our project level build.gradle file
- feat: upgrade the apollo graphql library
- feat: add the downloaded schema.json file
- feat: Add UsersQuery and auto-generate UsersQuery class with Apollo

This commit adds a new UsersQuery to the application. The UsersQuery class is auto-generated using
Apollo, based on the GraphQL schema.

The UsersQuery is designed to fetch a list of users from the server, with a set of predefined
fields. This query will be used in various parts of the application where a list of users is
required.

The UsersQuery class is generated automatically by the build process using Apollo's code generation
tools. This ensures that the class is always up-to-date with the latest changes in the schema, and
eliminates the need for manual updates.

Overall, this addition should improve the development process by simplifying the query creation
process and reducing the chance of errors or inconsistencies.

- feat(android): add graphql source directory

This commit adds the graphql folder to the Android Studio project. It ensures that the graphql
directory is visible when the project is in "Android" mode, making it easier to access and work with
GraphQL files in the Android project.

- feat: Configure Apollo Project and Retrieve GraphQL Data

This commit adds a new feature that involves configuring the Apollo Project and retrieving data
using GraphQL. Specifically, the changes made in this commit enable the setup of the Apollo Project
and the retrieval of data from a GraphQL server.

- feat: Implement Data Fetching and Displaying on Screen

This commit introduces a new feature that involves implementing data fetching and displaying it on
the screen. Specifically, the changes made in this commit enable the retrieval of additional data
and the rendering of it on the user interface.