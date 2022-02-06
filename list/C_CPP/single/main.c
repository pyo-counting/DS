#include <stdio.h>
#include "singlelist.h"

int		main(void) {
	SList*	slist;
	slist = SListNew();

	for (int i=0;i<10;i++)
		push_back(slist->header, i);
	for (t_SListNode* temp=slist->header->first;temp;temp=temp->next) {
		printf("%d ", temp->data);
	}
	putchar('\n');
	pop_front(slist->header);
	for (t_SListNode* temp=slist->header->first;temp;temp=temp->next) {
		printf("%d ", temp->data);
	}
	putchar('\n');
	pop_back(slist->header);
	printf("last : %d\n", slist->header->last->data);
	for (t_SListNode* temp=slist->header->first;temp;temp=temp->next)
		printf("%d ", temp->data);
	putchar('\n');

	printf("front: %d, back: %d\n", front(slist)->data, back(slist)->data);
}