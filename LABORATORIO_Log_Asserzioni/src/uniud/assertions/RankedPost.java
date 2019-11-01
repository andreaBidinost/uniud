package uniud.assertions;

public final class RankedPost {
	private String postId;
	private int rank;
	
	public static void main(String[] args) {
		RankedPost rp = new RankedPost("id22", 10);
		
		rp.getRankIncrease(-50);
		
		
	}

	public RankedPost(String id, int initialRank) {

		if (!isValidPostId(id)) {
			throw new IllegalArgumentException("Id is invalid.");
		}
		if (!isValidRank(initialRank)) {
			throw new IllegalArgumentException("Rank is invalid.");
		}

		this.postId = id;
		this.rank = initialRank;

		assert hasValidState() : "Construction failed - not valid state.";
	}

	public boolean isTopRanked() {
		return rank > 5;
	}

	public void growRank(int likesOfPastWeek) {

		int oldRank = rank;
		rank += getRankIncrease(likesOfPastWeek);

		assert rank > oldRank;

		assert hasValidState() : this;
	}

	public void decreaseRank() {

		class OriginalState {
			OriginalState() {
				originalRank = rank;
			}

			int getRank() {
				return originalRank;
			}

			private final int originalRank;
		}
		OriginalState originalState = null;
		
		assert (originalState = new OriginalState()) != null;

		if (rank > 1) {
			--rank;
		}
		
		assert rank <= originalState.getRank();
		
		assert hasValidState() : this;
	}

	
	public void updateRank(int likesOfPastWeek) {
		
		if (likesOfPastWeek == 0) {
			decreaseRank();
		} else if (likesOfPastWeek > 0) {
			growRank(likesOfPastWeek);
		} else {
			throw new AssertionError("Unexpected value for likes of past week: " + likesOfPastWeek);
		}
		
		assert hasValidState() : this;
	}

	/** Use for debugging only. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getClass().getName());
		result.append(": PostId=");
		result.append(postId);
		result.append(" Rank=");
		result.append(rank);
		return result.toString();
	}

	
	private boolean hasValidState() {
		return isValidPostId(postId) && isValidRank(rank);
	}

	
	private boolean isValidPostId(String id) {
		return id != null && id.trim().length() > 0 && id.startsWith("id");
	}

	private boolean isValidRank(int value) {
		return value > 0;
	}

	/** Rank increasing depends on the last likes received. */
	private int getRankIncrease(int likesOfPastWeek) {
		assert likesOfPastWeek > 0 : this;
		int result = likesOfPastWeek > 1000 ? 3 : 1;
		assert result > 0 : result;
		return result;
	}
}
