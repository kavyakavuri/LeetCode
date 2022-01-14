class Solution:
    
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        def medianOfArray(arr):
            res = 0
            index = []
            if(len(arr)%2 == 0):
                index.append(int(len(arr)/2-1))
                index.append(int(len(arr)/2))
                res = (arr[index[0]]+arr[index[1]])/2
            else:
                index.append(len(arr)//2)
                res = arr[index[0]]
            return res, index
        
        def calculateMedianLengthTwo(L,R):
            i = j = k = 0
            arr = [0]*(len(L)+len(R))
            if(len(arr)==0):
                return 0
            while i < len(L) and j < len(R):
                if L[i] < R[j]:
                    arr[k] = L[i]
                    i += 1
                else:
                    arr[k] = R[j]
                    j += 1
                k += 1
            while i < len(L):
                arr[k] = L[i]
                i += 1
                k += 1
            while j < len(R):
                arr[k] = R[j]
                j += 1
                k += 1
            res,index = medianOfArray(arr)
            return res
        
        def calculateMedianConcatenate(A,B):
            res=0
            if(A[-1]<=B[0]):
                res,index = medianOfArray(A+B)
            elif(B[-1]<=A[0]):
                res,index = medianOfArray(B+A)
            return res
            
        A = nums1
        B = nums2
        IndexAm = 0
        IndexBm = 0
        
        if(len(nums1)<len(nums2)):
            A = nums2
            B = nums1
        while(True):
            if(len(A)<=2 or len(B)<=2):
                return calculateMedianLengthTwo(A,B)
            elif(A[-1]<=B[0] or B[-1]<=A[0]):
                return calculateMedianConcatenate(A,B)
            Am,IndexAm = medianOfArray(A)
            Bm,IndexBm = medianOfArray(B)
            if(Am<=Bm):
                if(len(IndexBm)==2):
                    # print("here1")
                    discard_len = len(B[IndexBm[1]+1:])
                    B = B[:IndexBm[1]+1]
                    A = A[discard_len:]
                    # print("final A,B:",A,B)
                else:
                    # print("here2")
                    discard_len = len(B[IndexBm[0]+1:])
                    B = B[:IndexBm[0]+1]
                    A = A[discard_len:]
                    # print("final A,B:",A,B)
            else:
                if(len(IndexBm)==2):
                    # print("here3")
                    discard_len = len(B[:IndexBm[0]])
                    B = B[IndexBm[0]:]
                    A = A[:-discard_len]
                    # print("final A,B:",A,B)
                else:
                    # print("here4")
                    discard_len = len(B[:IndexBm[0]])
                    B = B[IndexBm[0]:]
                    A = A[:-discard_len]
                    # print("final A,B:",A,B)
        return 1.0