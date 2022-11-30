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

    int rows, choice;
    FILE *fp;
    fp=openfil("lotto.txt");

    printf("1. Randomize lottery rows\n2. Open file\n3. Quit\nEnter option: ");
    scanf("%i", &choice);

    switch(choice) {
        case 1:

            printf("Enter number of lottery rows: ");
            scanf("%i", &rows);
            
            if(rows > 0)
                randomWrite(fp, rows);
            
            else {
                
                printf("Enter positive number of lottery rows: ");
                scanf("%i", &rows);
            }
           break;

        case 2:
            
            printf("Reading from file:\n");
                openFile(fp);
            break;

        case 3:
            
                exit(1);
            break;
    }
}
