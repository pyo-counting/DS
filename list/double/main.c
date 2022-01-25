#include <stdio.h>
#include "doublelist.h"

int		main(void) {
	t_DListHeader* header = DListHeadNew();

	for (int i=0;i<10;i++)
		push_back(header, i);
	printf("front : %d, back: %d\n", front(header), back(header));
}