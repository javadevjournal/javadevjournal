package javadevjournal.designpatterns.creational.abstractfactory.example2;

/**
 * Abstract Factory - Factory of Factories
 */
public abstract class AbstractFactory{
   abstract IMobile getMobile(String mobileModel) ;
}