package grakkit;

import java.util.ArrayList;
import java.util.LinkedList;

import org.graalvm.polyglot.Value;

public class Queue {

   /** The list of values in the queue. */
   public final LinkedList<Value> list = new LinkedList<>();

   /** Executes and removes all values from the queue. */
   public void release() {
      try {
         new ArrayList<>(this.list).iterator().forEachRemaining(value -> {
            this.list.remove(value);
            try {
               value.executeVoid();
            } catch (Throwable error) {
               // do nothing
            }
         });
      } catch (Throwable error) {
         // do nothing
      }
   }
}
