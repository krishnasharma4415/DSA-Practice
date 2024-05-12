#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
    char username[20];
    char password[20];
    struct student* left;
    struct student* right;
};

struct student* createStudent(char username[], char password[]) {
    struct student* newStudent = (struct student*)malloc(sizeof(struct student));
    strcpy(newStudent->username, username);
    strcpy(newStudent->password, password);
    newStudent->left = NULL;
    newStudent->right = NULL;
    return newStudent;
}

struct student* insertStudent(struct student* root, char username[], char password[]) {
    if (root == NULL) {
        return createStudent(username, password);
    }
    if (strcmp(username, root->username) < 0) {
        root->left = insertStudent(root->left, username, password);
    } else if (strcmp(username, root->username) > 0) {
        root->right = insertStudent(root->right, username, password);
    }
    return root;
}

struct student* searchStudent(struct student* root, char username[], char password[]) {
    if (root == NULL || (strcmp(root->username, username) == 0 && strcmp(root->password, password) == 0)) {
        return root;
    }
    if (strcmp(username, root->username) < 0) {
        return searchStudent(root->left, username, password);
    } else {
        return searchStudent(root->right, username, password);
    }
}

int main() {
    struct student* root = NULL;

    // Inserting students into the binary search tree
    root = insertStudent(root, "Aryan", "password123");
    root = insertStudent(root, "Krishna", "hello456");
    root = insertStudent(root, "Alice", "alice789");
    root = insertStudent(root, "Dinesh", "letmein");
    root = insertStudent(root, "Akansha", "passAka11");
    root = insertStudent(root, "Maheep", "@heepwd");
    root = insertStudent(root, "Sara", "saraja45");

    // Inserting admin access
    root = insertStudent(root, "admin", "adminpassword");

    char userType[10];
    printf("Login as Admin or a Student: ");
    scanf("%s", userType);

    if (strcmp(userType, "Admin") == 0 || strcmp(userType, "admin") == 0) {
        char adminUsername[20], adminPassword[20];
        printf("Enter admin username: ");
        scanf("%s", adminUsername);
        printf("Enter admin password: ");
        scanf("%s", adminPassword);

        struct student* admin = searchStudent(root, adminUsername, adminPassword);
        if (admin != NULL && strcmp(admin->username, "admin") == 0) {
            printf("Admin login successful!\n");
            // Add admin access logic here
        } else {
            printf("Invalid admin username or password.\n");
        }
    } else {
        char username[20], password[20];
        printf("Enter your username: ");
        scanf("%s", username);
        printf("Enter your password: ");
        scanf("%s", password);

        struct student* student = searchStudent(root, username, password);
        if (student != NULL) {
            printf("Login successful!\n");
        } else {
            printf("Invalid username or password.\n");
        }
    }

    return 0;
}