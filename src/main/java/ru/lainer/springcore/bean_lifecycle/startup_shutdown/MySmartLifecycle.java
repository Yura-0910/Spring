package ru.lainer.springcore.bean_lifecycle.startup_shutdown;

import org.springframework.context.SmartLifecycle;

public class MySmartLifecycle implements SmartLifecycle {

  private boolean running = false;      //Работает ли данный бин
  private final int phase = Integer.MAX_VALUE;//Запуститься последним, остановиться первым

  @Override
  public void start() {
    running = true;
    System.out.println("MySmartLifecycle:: Бин получил сигнал запуска ApplicationContext(1)");
  }

  @Override
  public void stop() {
    running = false;
    System.out.println("MySmartLifecycle:: Бин получил сигнал остановки ApplicationContext(2)");
  }

  @Override
  public boolean isRunning() {
    System.out.println("MySmartLifecycle:: запущен ли бин ? " + running + "(3)");
    return running;
  }

  /**
   * Во время обновления контекста, если возвращается true, то бин запускается сразу и не ждет
   * вызова метода "start" из контекста или из этого bean-а
   */
  @Override
  public boolean isAutoStartup() {
    System.out.println("MySmartLifecycle::автоматически запускать бин при обновлении контекста(4)");
    return true;
  }

  @Override
  public void stop(Runnable callback) {
    System.out.println("MySmartLifecycle:: выполняем асинхронное завершение работы. "
        + "Callback отработает после завершения работы bean-а (5)");
    stop();
    callback.run();
  }

  //Определяет порядок запуска\остановки bean-ов
  @Override
  public int getPhase() {
    System.out.println("MySmartLifecycle:: Phase у bean-а = " + phase + "(6)");
    return phase;
  }
}
