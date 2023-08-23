from doublylinkedlist import Node
from doublylinkedlist import DoublyLinkedList


class ArrayStack:

	def __init__(self):
		self.data = []
		
	#현재 스택에 들어 있는 데이터 원소의 수를 구함
	def size(self):
		return len(self.data)
		
	#현재 스택이 비어 있는지를 판단
	def isEmpty(self):
		return self.size() == 0
		
	# 데이터 원소를 스택에 추가
	def push(self, item):
		self.data.append(item)

	#스택의 맨 위에 저장된 데이터 원소를 제거(또한, 반환)
	def pop(self):
		return self.data.pop()

	#스택의 맨 위에 저장된 데이터 원소를 반환(제거하지 않음, 확인)
	def peek(self):
		return self.data[-1]


class LinkedListStack:

	def __init__(self):
		self.data = DoublyLinkedList()

	def size(self):
		return self.data.getLength()

	def isEmpty(self):
		return self.size() == 0

	def push(self, item):
		node = Node(item)
		self.data.insertAt(self.size() + 1, node)

	def pop(self):
		return self.data.popAt(self.size())

	def peek(self):
		return self.data.getAt(self.size()).data
