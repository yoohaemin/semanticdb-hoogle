package example

import scala.meta.internal.semanticdb.{ Locator, MethodSignature, SymbolInformation }
import java.nio.file.Paths

import scala.collection.mutable
import scala.meta.internal.semanticdb.SymbolInformation.Kind.METHOD

//import scalaz.zio._


object Hello extends App {

  val map: mutable.Map[String, SymbolInformation] = mutable.Map.empty

  Locator(Paths.get("./semanticdb")) { (path, payload) =>
    payload.documents.map(_.symbols.collect {
      case s if s.kind == METHOD && !s.symbol.startsWith("local") =>
        s.signature match {
          case MethodSignature(typeParameters, parameterLists, returnType) =>
            val returnTypeRepr = returnType.asMessage.getTypeRef.symbol



          case _ => ???
        }
    }.foreach(a => println(s"$a")))


      ???


  }

  Locator(Paths.get("./Eq.scala.semanticdb")) { (path, payload) =>

    payload.documents.map(_.symbols.collect {
      case s if s.kind == METHOD && !s.symbol.startsWith("local") =>
      s.signature match {
        case MethodSignature(typeParameters, parameterLists, returnType) =>
//          (s.symbol, parameterLists.flatMap(_.symlinks), returnType)
          val returnTypeRepr = returnType.asMessage.getTypeRef.symbol

          (
              s.symbol,
              parameterLists.flatMap(_.symlinks),
              returnTypeRepr
          )

        case _ => ???
      }
    }.foreach(a => println(s"$a")))
  }

}
