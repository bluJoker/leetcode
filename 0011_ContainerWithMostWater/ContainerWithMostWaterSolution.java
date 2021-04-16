public class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }

        int maxArea = 0;

        // 暴力法
        /*for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
            }
        }*/

        // 双指针，详见官方解答
        // 感觉这个移动有点博弈论的味了，每次都移动自己最差的一边，虽然可能变得更差，但是总比不动（或者减小）强，动最差的部分可能找到更好的结果，
        // 但是动另一边总会更差或者不变，兄弟们，这不是题，这是人生，逃离舒适圈！！（这解释我觉得无敌了，哈哈哈）
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWaterSolution().maxArea(height));
    }
}
