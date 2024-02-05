
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print(char *str) {
    printf("%s", str);
}

void println(char *str) {
    printf("%s\n", str);
}

void printInt(int n) {
    printf("%d", n);
}

void printlnInt(int n) {
    printf("%d\n", n);
}

char *getString() {
    char *str = (char*)malloc(256);
    scanf("%s", str);
    return str;
}

int getInt() {
    int n;
    scanf("%d", &n);
    return n;
}

char *toString(int i) {
    char *str = (char *)malloc(12);
    sprintf(str, "%d", i);
    return str;
}

char *__malloc(int size) {
    return malloc(size);
}

char *__str_add(char *add_1, char *add_2) {
    char *res = malloc(strlen(add_1) + strlen(add_2) + 1);
    strcpy(res, add_1), strcat(res, add_2);
    return res;
}

char __str_eq(char *s1, char *s2) {
    return strcmp(s1, s2) == 0;
}

char __str_ne(char* s1, char* s2) {
    return strcmp(s1, s2) != 0;
}

char __str_lt(char* s1, char* s2) {
    return strcmp(s1, s2) < 0;
}

char __str_le(char* s1, char* s2) {
    return strcmp(s1, s2) <= 0;
}

char __str_gt(char* s1, char* s2) {
    return strcmp(s1, s2) > 0;
}

char __str_ge(char* s1, char* s2) {
    return strcmp(s1, s2) >= 0;
}

int __str_length(char *s) {
    return strlen(s);
}

char *__str_substring(char *s, int l, int r) {
    char *sub = malloc(r - l + 1);
    memcpy(sub, s + l, r - l);
    sub[r - l] = '\0';
    return sub;
}

int __str_parseInt(char *s) {
    int n;
    sscanf(s, "%d", &n);
    return n;
}

int __str_ord(char *s, int p) {
    return s[p];
}

int __array_size(void *head) {
    return ((int*)head)[-1];
}
