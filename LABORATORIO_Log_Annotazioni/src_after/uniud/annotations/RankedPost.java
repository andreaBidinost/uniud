package uniud.annotations;

public final class RankedPost {
	private String postId;
	private int rank;
	private final int baseOfTopRank = 5;
	
	public static void main(String[] args) {
				
	}

	/**
	 * Constructor of RankedPost class
	 * @param id post id REQUIRE id lenght must be > 0 and starts with "id"
	 * @param initialRank starting rank of post REQUIRE initialRank must be >0
	 */
	public RankedPost(String id, int initialRank) {

		if (!isValidPostId(id)) {
			throw new IllegalArgumentException("Id is invalid."); //eccezione: validazione di un parametro di un metodo pubblico
		}
		if (!isValidRank(initialRank)) {
			throw new IllegalArgumentException("Rank is invalid.");
		}

		this.postId = id;
		this.rank = initialRank;

		assert hasValidState() : "Construction failed - not valid state.";
	}

	
	public boolean isTopRanked() {
		return rank > baseOfTopRank;
		
	}

	public void growRank(int likesOfPastWeek) {

		int oldRank = rank;
		rank += getRankIncrease(likesOfPastWeek);//tempo e spazio sprecato per colpa delle asserzioni

		assert rank > oldRank;

		assert hasValidState() : this;
	}

	public void decreaseRank() {

		class OriginalState { //trucco: risparmio tempo e spazio (ma non logica) se le asserzioni sono disabilitate
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
		
		assert hasValidState() : this; //validazione dell'invariante
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
		assert likesOfPastWeek > 0 : this;//validazione di un parametro di un metodo privato
		int result = likesOfPastWeek > 1000 ? 3 : 1;
		assert result > 0 : result;
		return result;
	}
}
