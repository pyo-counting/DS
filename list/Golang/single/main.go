package main

import (
	"fmt"
	"slist/slist"
)

func main() {
	l := slist.New()
	fmt.Println(l)
	l.Push_front(1)
	fmt.Println(l.Front().Value)
	l.Push_back(3)
	fmt.Println(l.Back().Value)
	l.Pop_back()
	fmt.Println(l.Back().Value)
}
