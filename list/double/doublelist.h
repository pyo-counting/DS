#ifndef __DOUBLELIST_H__
#define __DOUBLELIST_H__

#include <stdbool.h>

// LinkedList Node
typedef struct	s_DListNode {
	struct s_DListNode* prev;
	struct s_DListNode* next;
	int					data;
}				t_DListNode;

// LinkedList Base
typedef struct	s_DListHeader {
	// member variable
	t_DListNode*	first;
	t_DListNode*	last;
	unsigned int	size;

	// member function
	bool (*empty)(struct s_DListHeader* self);
	void (*clear)(struct s_DListHeader* self);
}				t_DListHeader;

// List
typedef struct	s_list {
	t_DListHeader*	header;
}				list;

// push, pop
void push_front(t_DListHeader*, int);
void push_back(t_DListHeader*, int);
void pop_front(t_DListHeader*);
void pop_back(t_DListHeader*);

// front, back
t_DListNode* front(t_DListHeader*);
t_DListNode* back(t_DListHeader*);

// clear, insert, erase
t_DListNode*	insert(t_DListHeader*, t_DListNode*, int);
t_DListNode*	erase(t_DListHeader*, t_DListNode*);

// New Node, Header
t_DListNode*	DListNodeNew(int);
t_DListHeader*	DListHeadNew();

#endif