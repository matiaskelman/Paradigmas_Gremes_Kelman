package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( createQueue().isEmpty() );
  }


  @Test public void test02AddElementsToTheQueue() {
    assertFalse( createQueueWithAnElemSomething().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", createQueueWithAnElemSomething().head() );
  }



  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = createQueueWithAnElemSomething();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = createQueue();
    String addedObject = "Something";
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = createQueue();
    String firstAddedObject = "First";
    String secondAddedObject = "Second";

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = createQueue();
    String firstAddedObject = "First";

    queue.add( firstAddedObject );
    queue.add( "Second" );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    assertEquals( 1, createQueueWithAnElemSomething().size() );
    createQueueWithAnElemSomething().head();
    assertEquals( 1, createQueueWithAnElemSomething().size() );
  } 

@Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, createQueue().add( "First" ).add( "Second" ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = createQueue();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = createQueueWithAnElemSomething();
    queue.take();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = createQueue();
    try {
      queue.head();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }
  
  private Queue createQueue() {return new Queue();}
  
  private Queue createQueueWithAnElemSomething() {return createQueue().add( "Something" );}
} 
