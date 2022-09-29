package com.arpit.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void trappingWaterBruteFore() {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        assertEquals(10,trappingRainWater.trappingWaterBruteFore(new int[]{3,0,0,2,0,4}));
        assertEquals(10,trappingRainWater.trappingWaterBruteFore(new int[]{7,4,0,9}));
        assertEquals(0,trappingRainWater.trappingWaterBruteFore(new int[]{6,9,9}));
    }

    @Test
    void trappingWaterExtraSpace(){
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        assertEquals(10,trappingRainWater.trappingWaterExtraSpace(new int[]{3,0,0,2,0,4}));
        assertEquals(10,trappingRainWater.trappingWaterExtraSpace(new int[]{7,4,0,9}));
        assertEquals(0,trappingRainWater.trappingWaterExtraSpace(new int[]{6,9,9}));
    }
}