//
//  header.h
//  Laboration 3
//
//  Created by
//  Robin Johansson Speelgren
//  Anna-Maria Paleczek
//  on 2022-11-26.
//

#ifndef header_h
#define header_h
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

/* Prototyper */
FILE *openfil(char namn[]);
void randomWrite(FILE *fp, int rows);
void openFile(FILE *fp);

#endif
