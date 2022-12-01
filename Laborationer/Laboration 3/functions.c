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

void randomWrite(FILE *fp, int rows) {
    
    srand((int)time(NULL));
    
    int n = (rows * 7);
    int lottery[n];
    int size = (int)(sizeof(lottery) / sizeof(lottery[0])); //cast from long int to int.
    char lotteryStr[size];
    
    for(int i = 0; i < rows; i++) {
        
        for(int j = 0; j < 7; j++) {
         
            lottery[j] = rand() % 35 + 1;
        }
        
        for(int k = 0; k < 7; k++) {
            
            for(int l = 0; l < 7; l++) {
                
                int temp = lottery[k];
                lottery[k] = 0;
                
                while(temp == lottery[l]) {
                    
                    temp = rand() % 35 + 1;
                }
                
                lottery[k] = temp;
            }
        }
        
        for(int m = 0; m < 7; m++) {
            
            sprintf(lotteryStr, "%2i", lottery[m]);
            printf("%s ", lotteryStr);
            
            fputs(lotteryStr, fp);
            fputs(" ", fp);
            
            if((m + 1) % 7 == 0) {
                
                printf("\n");
                fputc('\n', fp);
            }
        }
    }
}

FILE *openfil(char namn[]) {
    
  FILE *fp;
  if ((fp = fopen(namn, "r+")) == NULL)
    if ((fp = fopen(namn, "w+")) == NULL){
        
      printf("Could not read file\n");
      return NULL;
  }
    
  return fp;
}

void openFile(FILE *fp) {
    
    char t;
    t = fgetc(fp);
    
    while(!feof(fp)) {
        
        printf("%c", t);
        t = fgetc(fp);
    }
}
