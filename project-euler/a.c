#include <string.h>
#include <stdio.h>
int getNextWordPos(const char*, int, int);
int score(char*);

void main() {
    char buffer[16384];
    int pos = 0;
    int nextPos = 0;
    char wordBuffer[256];

    int triNums[100];
    int count = 0;
    int i = 0;
    for (i = 0; i < 100; i++) {
        count += i;
        triNums[i] = count;
    }

    FILE* f = fopen("words.txt", "r");  
    fgets(buffer, 16384, f);
    close(f);
    while ((nextPos = getNextWordPos(buffer, 16384, pos)) > pos) {
        
        strncpy(wordBuffer, buffer+pos+1, (nextPos-pos-2));
        wordBuffer[nextPos-pos-2] = 0;
        int s = score(wordBuffer);
        for (i = 0; i < 100; i++) {
            if (triNums[i] == s) {
                printf("%s  %d\n", wordBuffer, score(wordBuffer));
            }
        }
        pos = nextPos+1;
    }
}

int getNextWordPos(const char* buffer, int bufsize, int pos) {
    int i = 0;
    while (buffer[pos+i] != 0 && buffer[pos+i] != ',' && (pos+i) < bufsize) {
        i++;
    } 
    if (buffer[pos+i] == 0) {
        i--;
    }
    return pos + i;
}

int score(char* word) {
    int count = 0;
    int i = 0; 
    while (word[i] != 0) {
        count += word[i] - 64;
        i++;
    }

    return count;
}
