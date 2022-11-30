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

FILE *openfil(char namn[]) {
    
  FILE *fp;
  if ((fp = fopen(namn, "r+")) == NULL)
    if ((fp = fopen(namn, "w+")) == NULL){
        
      printf("Could not read file\n");
      return NULL;
  }
    
  return fp;
}

void randomWrite(FILE *fp, int rows) {
    
    srand((int)time(NULL));
    
    int n = (rows * 7);
    int lottery[n];
    int size = (int)(sizeof(lottery) / sizeof(lottery[0])); //cast from long int to int.
    char lotteryStr[size];
    
    
    for(int i = 0; i < n; i++) {
        
        lottery[i] = i + 1;
    }
    
    for(int i = 0; i < n; i++) {
        
        int j = rand() % (n - i);
        int temp = lottery[(n - 1) - i];
        lottery[(n - 1) - i] = lottery[j];
        lottery[j] = temp;
    }
    
    for(int i = 0; i < n; i++) {
        
        sprintf(lotteryStr, "%2i", lottery[i]);
        printf("%s ", lotteryStr);
        
        fputs(lotteryStr, fp);
        fputs(" ", fp);
        
        if((i + 1) % 7 == 0) {
            
            printf("\n");
            fputc('\n', fp);
        }
    }
}

void openFile(FILE *fp) {
    
    char tkn;
    tkn = fgetc(fp);
    
    while(!feof(fp)) {
        
        printf("%c", tkn);
        tkn = fgetc(fp);
    }
}
