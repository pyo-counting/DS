package slist

import "fmt"

func (l *List) lazyInit() {
	if l.head.next == nil {
		l.Init()
	}
}

func (l *List) insert(e, at *Element) *Element {
	e.next = at.next
	at.next = e
	e.list = l
	l.len++
	fmt.Println(e)
	return e
}

func (l *List) insertValue(v interface{}, at *Element) *Element {
	return l.insert(&Element{Value: v}, at)
}

func (l *List) remove(prev, at *Element) *Element {
	prev.next = at.next
	at.list = nil
	at.next = nil
	return at
}
