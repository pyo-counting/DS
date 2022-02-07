package main

import (
	"./dlist"
	"fmt"
)

func main() {
	l := dlist.New()
	l.Push_front(1)
	fmt.Println(l.Front().Value)
	l.Push_front(2)
	fmt.Println(l.Front().Value)
	l.Push_back(3)
	fmt.Println(l.Back().Value)
	fmt.Println(l.Pop_back())
	fmt.Println(l.Back().Value)
}
