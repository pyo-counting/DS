#include <stdlib.h>
#include "doublelist.h"

/*
 * non visible function
 * bool empty(t_DListHeader*);
*/
static bool empty(t_DListHeader*);

void push_front(t_DListHeader* header, int data) {
	if (header->first != NULL) {
		header->first->prev = DListNodeNew(data);
		header->first->prev->next = header->first;
		header->first = header->first->prev;
	}
	else {
		header->first = DListNodeNew(data);
		header->last = header->first;
	}
	header->size++;
}

void push_back(t_DListHeader* header, int data) {
	if (header->last != NULL) {
		header->last->next = DListNodeNew(data);
		header->last->next->prev = header->last;
		header->last = header->last->next;
	}
	else {
		header->last = DListNodeNew(data);
		header->first = header->last;
	}
	header->size++;
}

void pop_front(t_DListHeader* header) {
	t_DListNode* temp;
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

void pop_back(t_DListHeader* header) {
	t_DListNode* temp;
	if (header->last == NULL) {
		return;
	}
	temp = header->last;
	if (header->first == header->last) {
		header->first = NULL;
		header->last = NULL;
	}
	else {
		header->last = header->last->prev;
	}
	free(temp);
	header->size--;
}

int front(t_DListHeader* header) {
	return header->first->data;
}

int back(t_DListHeader* header) {
	return header->last->data;
}

t_DListNode* DListNodeNew(int data) {
	t_DListNode* temp;
	temp = calloc(1, sizeof(t_DListNode));
	temp->data = data;
	return temp;
}

t_DListHeader* DListHeadNew() {
	t_DListHeader* temp;
	temp = calloc(1, sizeof(t_DListHeader));
	temp->empty = empty;
	return temp;
}

static bool empty(t_DListHeader* header) {
	if (header->size == 0)
		return true;
	return false;
}