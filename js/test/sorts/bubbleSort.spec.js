describe('Bubble Sort', function() {
  it('should correctly sort an array', function() {
    var bubbleSort = new BubbleSort();
    var arrayToSort = util.randomArray();

    // to safeguard against side-effects causing false positives
    expect(util.isSorted(arrayToSort)).toBe(false);

    var result = bubbleSort.sort(arrayToSort);

    expect(util.isSorted(result)).toBe(true);
  })
})
