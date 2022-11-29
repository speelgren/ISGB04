//
//  randomWrite.c
//  Laboration 3
//
//  Created by
//  Robin Johansson Speelgren
//  Anna-Maria Paleczek
//  on 2022-11-26.
//

#include "header.h"

int randomWrite(FILE *fp, int lr) {
    
    fp = fopen("lotto.txt", "w");
    srand((int)time(NULL));
    int lottery[7];
    
    for(int i = 0; i < lr; i++) {
        
        for(int j = 0; j < 7; j++) {
            
            lottery[j] = rand() % 35 + 1;
            printf("%2i ", lottery[j]);
        }
        
        fwrite(lottery, 1, sizeof(lottery), fp);
        printf("\n");
    }
    
    fclose(fp);
    return 0;
}

int openFile(FILE *fp) {
    
    char tkn;
    tkn = fgetc(fp);
    while(!feof(fp)) {
        printf("%c", tkn);
        tkn=fgetc(fp);
    }
    
    return 0;
}
