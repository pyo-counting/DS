#include <stdio.h>
#include "doublelist.h"

int		main(void) {
	t_DListHeader* header = DListHeadNew();

	for (int i=0;i<10;i++)
		push_back(header, i);
	printf("front : %p, back: %p\n", front(header), back(header));
	printf("size : %d\n", header->size);
	erase(header, header->first->next);
	printf("front : %p, back: %p\n", front(header), back(header));
	printf("size : %d\n", header->size);
}