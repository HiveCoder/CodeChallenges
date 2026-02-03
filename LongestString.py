class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen_chars = set()
        left = 0 
        max_count = 0 
    
        for i in range(len(s)):
            while s[i] in seen_chars : 
                seen_chars.remove(s[left])
                left += 1 
            
            seen_chars.add(s[i])
            size = i - left +1 
            if size > max_count : 
                max_count = len(seen_chars)
            
        return max_count 
