package cumt.tj.learn.algorithms.divide;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sky on 17-9-5.
 */
public class QuickMatrixPowTest {

    @Test
    public void matrixPow(){

        QuickMatrixPow qmp=new QuickMatrixPow();

        assertArrayEquals(qmp.quickMatrixPow(
                new int[][]{
                        {1,2,3},
                        {1,3,4},
                        {1,3,4}},1),
                new int[][]{
                        {1,2,3},
                        {1,3,4},
                        {1,3,4}});


        assertArrayEquals(qmp.quickMatrixPow(
                new int[][]{
                        {1,2,3},
                        {1,3,4},
                        {1,3,4}},2),
                new int[][]{
                        {6,17,23},
                        {8,23,31},
                        {8,23,31}});
    }

    @Test
    public void matrixMult(){

        QuickMatrixPow qmp=new QuickMatrixPow();

        assertArrayEquals(qmp.matrixMult(
                new int[][]{
                        {1,2,3},
                        {1,3,4},
                        {1,3,4}},
                new int[][]{
                        {1,2,3},
                        {1,3,4},
                        {1,3,4}}),
                new int[][]{
                        {6,17,23},
                        {8,23,31},
                        {8,23,31}});

    }

}
