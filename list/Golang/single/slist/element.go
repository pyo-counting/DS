package slist

// struct
type Element struct {
	next  *Element
	list  *List
	Value interface{}
}

func (e *Element) Next() *Element {
	if p := e.next; e.list != nil && p != &e.list.head {
		return p
	}
	return nil
}
