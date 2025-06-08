# Counting Beautiful Sequences in a Colored Tree

## Problem Statement
Given:
- A tree with `n` vertices (n ≤ 10^5)
- Each edge is colored either RED or BLUE
- A sequence of vertices [v₁, v₂, ..., vₖ] (k ≤ 100) is called "ugly" if:
  - The walk (using shortest paths between consecutive vertices) contains edges of only one color
  - Sequences with no edges (single-vertex walks) are NOT considered ugly
- Find the count of "beautiful" sequences (all sequences that aren't ugly) modulo 10⁹+7

## Key Observations

### Tree Properties
- Unique path between any two vertices
- No cycles

### Sequence Analysis
- Total possible sequences: nᵏ
- Need to subtract "ugly" sequences from total

### Color Constraints
- An "ugly" sequence must maintain single-color paths throughout
- Mixed-color paths make sequences "beautiful"

## Solution Approach

### Preprocessing
- For each node pair (u,v), precompute:
  - Path length
  - Whether path is monochromatic (all RED/all BLUE)

### Dynamic Programming
- `DP[i][c]` = count of sequences of length i ending with color c
- Transition based on monochromatic paths between vertices

### Efficient Calculation
- Compute total ugly sequences (all-RED + all-BLUE - single-vertex sequences)
- Beautiful sequences = Total sequences (nᵏ) - Ugly sequences

**Time**: O(n)  
**Space**: O(n)  

##

hw1-analys-algo
