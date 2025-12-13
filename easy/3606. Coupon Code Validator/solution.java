#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

int cmp(const void* a, const void* b) {
    return strcmp(*(char**)a, *(char**)b);
}

char** validateCoupons(char** code, int codeSize,
                       char** businessLine, int businessLineSize,
                       bool* isActive, int isActiveSize,
                       int* returnSize) {

    char** e = malloc(codeSize * sizeof(char*));
    char** g = malloc(codeSize * sizeof(char*));
    char** p = malloc(codeSize * sizeof(char*));
    char** r = malloc(codeSize * sizeof(char*));

    int ec=0,gc=0,pc=0,rc=0;

    for (int i = 0; i < isActiveSize; i++) {
        if (!isActive[i]) continue;

        if (strcmp(businessLine[i], "electronics") &&
            strcmp(businessLine[i], "grocery") &&
            strcmp(businessLine[i], "pharmacy") &&
            strcmp(businessLine[i], "restaurant"))
            continue;

        if (strlen(code[i]) == 0) continue;

        bool ok = true;
        for (int j = 0; code[i][j]; j++) {
            if (!isalnum(code[i][j]) && code[i][j] != '_') {
                ok = false; break;
            }
        }
        if (!ok) continue;

        if (businessLine[i][0] == 'e') e[ec++] = code[i];
        if (businessLine[i][0] == 'g') g[gc++] = code[i];
        if (businessLine[i][0] == 'p') p[pc++] = code[i];
        if (businessLine[i][0] == 'r') r[rc++] = code[i];
    }

    qsort(e, ec, sizeof(char*), cmp);
    qsort(g, gc, sizeof(char*), cmp);
    qsort(p, pc, sizeof(char*), cmp);
    qsort(r, rc, sizeof(char*), cmp);

    char** res = malloc((ec+gc+pc+rc) * sizeof(char*));
    int idx = 0;
    for (int i=0;i<ec;i++) res[idx++] = e[i];
    for (int i=0;i<gc;i++) res[idx++] = g[i];
    for (int i=0;i<pc;i++) res[idx++] = p[i];
    for (int i=0;i<rc;i++) res[idx++] = r[i];

    *returnSize = idx;
    return res;
}