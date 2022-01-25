#include <stdlib.h>
#include "doublelist.h"

/*
 * non visible function
 * bool empty(t_DListHeader*);
*/
static bool empty(t_DListHeader*);
static void clear(t_DListHeader*);

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

t_DListNode* front(t_DListHeader* header) {
	if (header->first == NULL)
		return NULL;
	return header->first;
}

t_DListNode* back(t_DListHeader* header) {
	if (header->last == NULL)
		return NULL;
	return header->last;
}

t_DListNode* insert(t_DListHeader* header, t_DListNode* position, int data) {
	t_DListNode* temp;
	if (position == NULL) {
		return NULL;
	}
	temp = DListNodeNew(data);
	temp->prev = position;
	temp->next = position->next;
	position->next = temp;
	if (header->last == position)
		header->last = temp;
	header->size++;
	return temp;
}

t_DListNode* erase(t_DListHeader* header, t_DListNode* position) {
	t_DListNode* prev;
	t_DListNode* next;
	if (position == NULL) {
		return NULL;
	}
	prev = position->prev;
	next = position->next;
	if (prev != NULL)
		prev->next = next;
	if (next != NULL)
		next->prev = prev;
	if (position == header->first)
		header->first = next;
	if (position == header->last)
		header->last = prev;
	header->size--;
	free(position);
	return next;
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
	temp->clear = clear;
	return temp;
}

// static function
static bool empty(t_DListHeader* self) {
	if (self->size == 0)
		return true;
	return false;
}

static void clear(t_DListHeader* self) {
	if (self->first == NULL)
		return;
	while (!self->empty(self)) {
		pop_front(self);
	}
}