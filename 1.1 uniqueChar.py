'''
Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional datastrutures?
'''
def checkUniqueChar(s):
	dic=dict()
	for ch in s:
		if ch in dic:
			return False
		else:
			dic[ch]=None
	return True

def getDuplicateChar(s):
	dic=dict()
	for ch in s:
		if ch in dic:
			dic[ch]=dic[ch]+1
		else:
			dic[ch]=1
	return dic

def printDuplicateChar(s):
	dic=getDuplicateChar(s)
	for key,value in dict.items(dic):
		if value>=2:
			print (key,value)
