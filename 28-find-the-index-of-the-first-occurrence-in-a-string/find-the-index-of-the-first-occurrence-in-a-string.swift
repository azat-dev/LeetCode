class Solution {

    func hasSubstring(
        _ substring: String,
        in string: String, 
        from startIndex: String.Index
    ) -> Bool {

        var index = startIndex

        for substringCharacter in substring {

            if index == string.endIndex {
                return false
            }

            if substringCharacter != string[index] {
                return false
            }

            index = string.index(after: index)
        }

        return true
    }

    func strStr(_ haystack: String, _ needle: String) -> Int {

        for startIndex in haystack.indices {

            if hasSubstring(needle, in: haystack, from: startIndex) {
                return haystack.distance(from: haystack.startIndex, to: startIndex)
            }
        }

        return -1
    }

    func strStr_VersionWithStandartFunctions(_ haystack: String, _ needle: String) -> Int {
        let range = haystack.range(of: needle)
        
        guard let lowerBound = range?.lowerBound else {
            return -1
        }
        
        return haystack.distance(from: haystack.startIndex, to: lowerBound)
    }
}