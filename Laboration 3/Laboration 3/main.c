//
//  main.c
//  Laboration 3
//
//  Created by
//  Robin Johansson Speelgren
//  Anna-Maria Paleczek
//  on 2022-11-26.
//

#include "header.h"

int main(int argc, const char * argv[]) {
    
    int lr, c;
    FILE *fp;
    
    printf("1. Open file\n2. Create file\n");
    printf("Enter option: ");
    scanf("%i", &c);
    
    switch(c) {
            
        case 1:
            openFile(fp);
            break;
        case 2:
            printf("Enter number of lottery tickets: ");
            scanf("%i", &lr);
            
            if(lr > 0) {
                
                randomWrite(fp, lr);
            } else {
                printf("Enter positive number of lottery ticket: ");
                scanf("%i", &lr);
            }
    }
    
    return 0;
}

FILE *openfil(char namn[]) {
    
    FILE *fp;
    if((fp = fopen(namn, "r+")) == NULL)
        if((fp = fopen(namn, "w+")) == NULL) {
            
            printf("fel\n");
            return NULL;
        }
    
    return fp;
}
