class FindingFloorInArray {
    public List<Integer> findFloor(List<Integer> arr, List<Integer> queries) {
        Collections.sort(arr);
        List<Integer> ans = new ArrayList<>();
        for (int i : queries) {
            int l = 0,h = arr.size() - 1,floor = -1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (arr.get(mid) == i) {
                    floor = arr.get(mid);
                    break;
                } else if (arr.get(mid) > i) {
                    h = mid - 1;
                } else {
                    floor = arr.get(mid);
                    l = mid + 1;
                }
            }
            ans.add(floor);
        }
        return ans;
    }
}
class FindingCeilInArray {
    public int ceilValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
class FindCorruptIndex {
    public int findCorruptIndex(int[] file) {
    int low = 0, high = file.length - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (file[mid] == 0) {
            ans = mid; 
            high = mid - 1;
        } else {
            low = mid + 1; 
        }
    }
    return ans;
    }
}
class CountWithinRange {
    public List<Integer> countValuesLieInRange(List<Integer> a, List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        Collections.sort(a);
        for (List<Integer> q : queries) {
            int low = ceil(a, q.get(0));  
            int high = floor(a, q.get(1)); 
            ans.add(high - low + 1);
        }
        return ans;
    }
    public static int floor(List<Integer> a, int ele) {
        int ans = -1;
        int l = 0, h = a.size() - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a.get(mid) <= ele) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(List<Integer> a, int ele) {
        int ans = a.size();
        int l = 0, h = a.size() - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a.get(mid) >= ele) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
class CubeRoot {
    public long cubeRoot(long n) {
        long l = -1000000;
        long h = 1000000;
        while (l <= h) {
            long mid = l + (h - l) / 2;
            long cub = mid * mid * mid;
            if (cub == n) return mid;
            else if (cub > n) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1; 
    }
}
class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long l = 0,h = n / 2 + 1;
            long ans = 1;
            while (l <= h) {
                long mid = l + (h - l) / 2;
                if (mid == n / mid) {
                    ans = mid;
                    break;
                } else if (mid < n / mid) {
                    ans = mid;
                    l = mid + 1;
                } else h=mid-1;
            }
            System.out.println(ans);
        }
    }
}
class SearchInSortedRotatedArray {
    public int findIndexInSortedRotated(int[] A, int key) {
        int l = 0;
        int h = A.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (A[mid] == key) return mid;
            if (A[l] <= A[mid]) {
                if (key >= A[l] && key <= A[mid]) {
                    h = mid - 1;
                } else l = mid + 1;
            }
            else {
                if (key >= A[mid] && key <= A[h]) {
                    l = mid + 1;
                } else h = mid - 1;
            }
        }
        return -1; 
    }
}
class NumberOfZeros {
    public int solve(int a[]) {
        int ans = -1;
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] != 0) {
                h = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans + 1;
    }
}
class KokoEatingBananas {
    public int minEatingSpeed(int[] arr, int h) {
        int low = 1;
        int high = (int)1e9;
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (answer(arr, mid, h)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
    boolean answer(int[] arr, int mid, int h) {
        int time = 0;
        for (int ele : arr) {
            time += (ele + mid - 1) / mid;
        }
        return time <= h;
    }
}