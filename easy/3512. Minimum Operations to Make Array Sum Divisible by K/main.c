// 3512. Minimum Operations to Make Array Sum Divisible by K
int minOperations(int* nums, int numsSize, int k) {
    long long sum = 0;
    for (int i = 0; i < numsSize; i++) {
        sum += nums[i];
    }
    
    int remainder = sum % k;
    return remainder;
}