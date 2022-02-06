#include <stdio.h>
#include <stdlib.h>
#include "singlelist.h"

/*
 * non visible function
*/
static bool emtpy(t_SListHeader*);
static void clear(t_SListHeader*);

void push_front(t_SListHeader* header, int data) {
	if (header->first != NULL) {
		t_SListNode* temp;
		temp = SListNodeNew(data);
		temp->next = header->first;
		header->first = temp;
	}
	else {
		header->first = SListNodeNew(data);
		header->last = header->first;
	}
	header->size++;
}

void push_back(t_SListHeader* header, int data) {
	if (header->last != NULL) {
		header->last->next = SListNodeNew(data);
		header->last = header->last->next;
	}
	else {
		header->last = SListNodeNew(data);
		header->first = header->last;
	}
	header->size++;
}

void pop_front(t_SListHeader* header) {
	t_SListNode* temp;
	if (header->first == NULL) {
		return;
	}
	temp = header->first;
	if (header->first == header->last) {
		header->first = NULL;
		header->last = NULL;
	}
	else {
		header->first = header->first->next;
	}
	free(temp);
	header->size--;
}

void pop_back(t_SListHeader* header) {
	t_SListNode* temp;
	if (header->last == NULL) {
		return;
	}
	temp = header->first;
	if (header->first == header->last) {
		header->first = NULL;
		header->last = NULL;
	} else {
		while (temp->next != header->last) {
			temp = temp->next;
		}
		header->last = temp;
		header->last->next = NULL;
		temp = temp->next;

	}
	free(temp);
	header->size--;
}

t_SListNode* SListNodeNew(int data) {
	t_SListNode* temp;
	temp = calloc(1, sizeof(t_SListNode));
	if (temp == NULL) {
		fprintf(stderr, "memory allocate failed");
		exit(1);
	}
	temp->data = data;
	return temp;
}

t_SListHeader* SListHeaderNew() {
	t_SListHeader* temp;
	temp = calloc(1, sizeof(t_SListHeader));
	if (temp == NULL) {
		fprintf(stderr, "memory allocate failed");
		exit(1);
	}
	return temp;
}

t_SListNode* front(SList* list) {
	if (list == NULL)
		return NULL;
	return list->header->first;
}

t_SListNode* back(SList* list) {
	if (list == NULL)
		return NULL;
	return list->header->last;
}

SList* SListNew() {
	SList* temp;
	temp = calloc(1, sizeof(SList));
	if (temp == NULL) {
		fprintf(stderr, "memory allocate failed");
		exit(1);
	}
	temp->header = SListHeaderNew();
	return temp;
}